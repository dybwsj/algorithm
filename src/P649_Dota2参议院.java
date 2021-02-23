public class P649_Dota2参议院 {
    public String predictPartyVictory(String senate) {
        return whoWin(senate, 0, 0);
    }

    private String whoWin(String senate, int r, int d) {
        StringBuilder sb = new StringBuilder();
        boolean Rwin = true;
        boolean Dwin = true;
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                if (d > 0) {
                    d--;
                } else {
                    r++;
                    Dwin = false;
                    sb.append(senate.charAt(i));
                }
            } else {
                if (r > 0) {
                    r--;
                } else {
                    d++;
                    Rwin = false;
                    sb.append(senate.charAt(i));
                }
            }
        }
        if (Rwin) {
            return "Radiant";
        }
        if (Dwin) {
            return "Dire";
        }
        return whoWin(sb.toString(), r, d);
    }
}
