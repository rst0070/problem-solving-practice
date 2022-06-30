import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class 파일_탐색기_20210 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        LinkedList<String>[] words = new LinkedList[N];
        for(int i = 0; i < N; i++){
            words[i] = new LinkedList<String>();
            String str = br.readLine();

            for(int j = 0; j < str.length(); j++){

                if(str.charAt(j) <= '9'){
                    int s = j;
                    while(j+1 < str.length() && str.charAt(j+1) <= '9') j++;
                    words[i].add(str.substring(s, j+1));

                }else{
                    words[i].add(str.charAt(j) + "");
                }
            }
        }

        Arrays.sort(words, (LinkedList<String> w1, LinkedList<String> w2)->{
            Iterator<String> i1 = w1.iterator();
            Iterator<String> i2 = w2.iterator();

            while(i1.hasNext() && i2.hasNext()){
                String word1 = i1.next();
                String word2 = i2.next();

                if(word1.equals(word2)) continue;

                char c1 = word1.charAt(0);
                char c2 = word2.charAt(0);

                //둘다 숫자
                if(c1 <= '9' && c2 <= '9'){
                    int z1 = 0, z2 = 0;
                    BigInteger b1 = null, b2 = null;
                    for(; z1 < word1.length() && word1.charAt(z1) == '0'; z1++);
                    for(; z2 < word2.length() && word2.charAt(z2) == '0'; z2++);

                    if(z1 == word1.length()) b1 = BigInteger.ZERO;
                    else b1 = new BigInteger(word1.substring(z1, word1.length()));
                
                    if(z2 == word2.length()) b2 = BigInteger.ZERO;
                    else b2 = new BigInteger(word2.substring(z2, word2.length()));

                    int result = b1.compareTo(b2);
                    if(result == 0){
                        if(z1 < z2) return -1;
                        return 1;
                    }
                    return result;
                }
                //한쪽만 숫자
                if(c1 <= '9')
                    return -1;
                

                if(c2 <= '9'){
                    return 1;
                }

                //둘다 대문자. 혹은 둘다 소문자
                if((c1 <= 'Z' && c2 <= 'Z') || (c1 >= 'a' && c2 >= 'a')){
                    if(c1 < c2) return -1;
                    else if(c1 == c2) return 0;
                    else return 1;
                }else if(c1 <= 'Z'){//첫번째만 대문자
                    if(((int)c1 + 32) <= c2)
                        return -1;
                    else
                        return 1;
                }else{
                    if(c1 < ((int)c2 + 32))
                        return -1;
                    else
                        return 1;
                }
            }
            if(i1.hasNext()) return 1;
            if(i2.hasNext()) return -1;
            return 0;
        });
        
        for(int i = 0; i < N; i++){
            while(!words[i].isEmpty()){
                bw.write(words[i].poll());
            }
            bw.write('\n');
        }
        bw.flush();
        bw.close();
        br.close();
    }

    


}
