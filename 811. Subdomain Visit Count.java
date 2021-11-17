class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        int n = cpdomains.length;
        Map<String, Integer> freqMap = new HashMap<>();
        for (String cpdomain : cpdomains) {
            //System.out.println(cpdomain);
            String[] str1 = cpdomain.split(" ");
            int cnt = Integer.parseInt(str1[0]);
            String fullText = str1[1];
            //System.out.println(fullText);
            String[] domains = fullText.split("\\.");
            int m = domains.length;
            //System.out.println(m);
            String sb = "";
            for (int i = m - 1; i >=0; i--) {
                if (i == m - 1) 
                    sb = domains[i];
                else 
                    sb = domains[i] + "." + sb;
                //System.out.println(domains[i]);
                freqMap.put(sb, freqMap.getOrDefault(sb, 0) + cnt);
            }            
        }
        List<String> results = new ArrayList<>();
        for (String key : freqMap.keySet()) {
            //System.out.println(key);
            results.add(freqMap.get(key) + " " + key);
        }
        return results;
    }
}
