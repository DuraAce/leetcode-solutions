class Solution {
    public String originalDigits(String s) {
        // frequency map
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        List<Integer> nums = new ArrayList<>();
        analyze(s, freq, nums);
        Collections.sort(nums);
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num);
        }
        return sb.toString();
    }
    
    public void analyze(String s, Map<Character, Integer> freq, List<Integer> nums) {
        int cnt = 0;
        if (freq.containsKey('z') && freq.get('z') > 0) {
            cnt = freq.get('z');
            freq.put('z', freq.get('z') - cnt);
            freq.put('e', freq.get('e') - cnt);
            freq.put('r', freq.get('r') - cnt);
            freq.put('o', freq.get('o') - cnt);
            for (int i = 0; i < cnt; i++) {
                nums.add(0);
            }
        }
        if (freq.containsKey('w') && freq.get('w') > 0) {
            cnt = freq.get('w');
            freq.put('t', freq.get('t') - cnt);
            freq.put('w', freq.get('w') - cnt);
            freq.put('o', freq.get('o') - cnt);
            for (int i = 0; i < cnt; i++) {
                nums.add(2);
            }
        }
        if (freq.containsKey('x') && freq.get('x') > 0) {
            cnt = freq.get('x');
            freq.put('s', freq.get('s') - cnt);
            freq.put('i', freq.get('i') - cnt);
            freq.put('x', freq.get('x') - cnt);
            for (int i = 0; i < cnt; i++) {
                nums.add(6);
            }
        }
        if (freq.containsKey('g') && freq.get('g') > 0) {
            cnt = freq.get('g');
            freq.put('e', freq.get('e') - cnt);
            freq.put('i', freq.get('i') - cnt);
            freq.put('g', freq.get('g') - cnt);
            freq.put('h', freq.get('h') - cnt);
            freq.put('t', freq.get('t') - cnt);
            for (int i = 0; i < cnt; i++) {
                nums.add(8);
            }
        }
        if (freq.containsKey('s') && freq.get('s') > 0) {
            cnt = freq.get('s');
            freq.put('s', freq.get('s') - cnt);
            freq.put('e', freq.get('e') - cnt);
            freq.put('v', freq.get('v') - cnt);
            freq.put('e', freq.get('e') - cnt);
            freq.put('n', freq.get('n') - cnt);
            for (int i = 0; i < cnt; i++) {
                nums.add(7);
            }
        }
        if (freq.containsKey('v') && freq.get('v') > 0) {
            cnt = freq.get('v');
            freq.put('f', freq.get('f') - cnt);
            freq.put('i', freq.get('i') - cnt);
            freq.put('v', freq.get('v') - cnt);
            freq.put('e', freq.get('e') - cnt);
            for (int i = 0; i < cnt; i++) {
                nums.add(5);
            }
        }  
        if (freq.containsKey('f') && freq.get('f') > 0) {
            cnt = freq.get('f');
            freq.put('f', freq.get('f') - cnt);
            freq.put('o', freq.get('o') - cnt);
            freq.put('u', freq.get('u') - cnt);
            freq.put('r', freq.get('r') - cnt);
            for (int i = 0; i < cnt; i++) {
                nums.add(4);
            }
        }    
        if (freq.containsKey('o') && freq.get('o') > 0) {
            cnt = freq.get('o');
            freq.put('o', freq.get('o') - cnt);
            freq.put('n', freq.get('n') - cnt);
            freq.put('e', freq.get('e') - cnt);
            for (int i = 0; i < cnt; i++) {
                nums.add(1);
            }
        }     
        if (freq.containsKey('h') && freq.get('h') > 0) {
            cnt = freq.get('h');
            freq.put('t', freq.get('t') - cnt);
            freq.put('h', freq.get('h') - cnt);
            freq.put('r', freq.get('r') - cnt);
            freq.put('e', freq.get('e') - cnt);
            freq.put('e', freq.get('e') - cnt);
            for (int i = 0; i < cnt; i++) {
                nums.add(3);
            }
        }  
        if (freq.containsKey('i') && freq.get('i') > 0) {
            cnt = freq.get('i');
            freq.put('n', freq.get('n') - cnt);
            freq.put('i', freq.get('i') - cnt);
            freq.put('n', freq.get('n') - cnt);
            freq.put('e', freq.get('e') - cnt);
            for (int i = 0; i < cnt; i++) {
                nums.add(9);
            }
        } 
    }
}

