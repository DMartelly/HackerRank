package _java.strings;

import java.util.*;

public class TagContentExtractor{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while(testCases>0){
            String line = in.nextLine();
            StringBuilder ans = new StringBuilder();
            StringBuilder ans2 = new StringBuilder();
            StringBuilder eTag = new StringBuilder();
            boolean fOpen = false,
                    fClose = false;
            Stack<String> tag = new Stack<>();
            for(int i = 0; i < line.length(); i++){
                if(line.charAt(i) == '<'){
                    if(line.charAt(i+1) == '/'){
                        fClose = true;
                        i++;
                    }
                    fOpen = true;
                } else if(line.charAt(i) == '>'){
                    fOpen = false;
                    if (!fClose){
                        tag.push(eTag.toString());
                        eTag = new StringBuilder();
                    } else {
                        String c = tag.pop();
                        if(c.equals(eTag.toString())){
                            ans2.append(ans.toString());
                            ans = new StringBuilder();
                        }
                        eTag = new StringBuilder();
                        fClose = false;
                    }

                } else {
                    if (fOpen){
                        eTag.append(line.charAt(i));
                    }else if (!tag.isEmpty()){
                        ans.append(line.charAt(i));
                    }
                }
            }
            if(ans2.length() == 0){
                System.out.println("None");
            } else {
                System.out.println(ans2.toString());
            }

            testCases--;
        }
    }
}
