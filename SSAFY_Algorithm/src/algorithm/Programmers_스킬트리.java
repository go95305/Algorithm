package algorithm;

public class Programmers_스킬트리 {
    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        int cnt = 0;

        for (int i = 0; i < skill_trees.length; i++) {
            boolean flag = true;
            int latest = -1;
            for (int j = 0; j < skill_trees[i].length(); j++) {
                if (skill.contains(Character.toString(skill_trees[i].charAt(j)))) {

                    if (latest + 1 != skill.indexOf(skill_trees[i].charAt(j))) {
                        flag = false;
                        break;
                    } else {
                        latest = skill.indexOf(skill_trees[i].charAt(j));
                    }

                }
            }
            if (flag)
                cnt++;
        }
        System.out.println(cnt);
    }
}
