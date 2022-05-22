package com.github.emcc13.cobbler;

import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;

import java.util.*;

public class Generator {
    private class Condition {
        private int less;
        private int layer;

        public Condition(boolean less, int layer) {
            if (less) {
                this.less = 1;
            } else {
                this.less = -1;
            }
            this.layer = layer;
        }

        public boolean isTrue(int height) {
            return this.less * (this.layer - height) > 0;
        }
    }

    private List<Condition> conditions;
    private Material[] materials;
    private Random randomGenerator;

    public Generator(String condition, ConfigurationSection cs) {
        this.conditions = new LinkedList<>();
        for (String con : condition.split(",")) {
            if (con.toLowerCase().equals("default")) {
                this.conditions.add(
                        new Condition(true, Integer.MAX_VALUE)
                );
                continue;
            }
            switch (con.charAt(0)) {
                case '<':
                    this.conditions.add(new Condition(true, Integer.parseInt(con.substring(1))));
                    break;
                case '>':
                    this.conditions.add(new Condition(false, Integer.parseInt(con.substring(1))));
                    break;
                case '=':
                    this.conditions.add(new Condition(false, Integer.parseInt(con.substring(1)) - 1));
                    this.conditions.add(new Condition(true, Integer.parseInt(con.substring(1)) + 1));
                    break;
                default:
                    break;
            }
        }
        this.randomGenerator = new Random();
        List<Material> tmp_material = new LinkedList<>();
        Map<String, Integer> material_prob = new HashMap<>();
        List<Integer> probs_list = new LinkedList<>();
        for (String key : cs.getKeys(false)) {
            probs_list.add(cs.getInt(key));
            material_prob.put(key, cs.getInt(key));
        }
        Integer[] probs = probs_list.toArray(new Integer[]{});
        int ggt_v = 1;
        if (material_prob.size() > 1) {
            ggt_v = ggt(probs[0], probs[1]);
            for (int i = 2; i < probs.length; i++) {
                ggt_v = ggt(ggt_v, probs[i]);
            }
        }
        for (Map.Entry<String, Integer> entry : material_prob.entrySet()) {
            tmp_material.addAll(Collections.nCopies(entry.getValue() / ggt_v, Material.getMaterial(entry.getKey())));
        }
        this.materials = tmp_material.toArray(new Material[]{});
    }

    public Material getMaterial(int height) {
        boolean accepted = true;
        for (Condition con : this.conditions) {
            accepted &= con.isTrue(height);
        }
        if (accepted) {
            return this.materials[this.randomGenerator.nextInt(this.materials.length)];
        }
        return null;
    }

    public static int ggt(int a, int b) {
        if (b == 0) return a;
        return ggt(b, a % b);
    }
}
