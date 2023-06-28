package study;

import java.util.*;


// 함께 주문된 단품메뉴 조합에 따라
// "스카피"가 만들게 될 코스요리 메뉴 구성 후보 결정
// orders = 주문한 단품메뉴들
// course = 코스요리 개수
// 결과는 오름차순 정렬
public class MenuRenew {
    public static Map<String, Integer> map = new HashMap<>();
    public static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        MenuRenew T = new MenuRenew();
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2,3,4};
        System.out.println(Arrays.toString(T.solution(orders,course)));
//        for(String x : T.solution(orders, course)) System.out.println(x);

    }
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        for(int  i = 0 ;i<orders.length; i++){
            char [] charArrays = orders[i].toCharArray();
            Arrays.sort(charArrays);
            for(int j = 0 ; j <charArrays.length; j++){
                for(int  index = 0 ; index<course.length ; index++){
                    search(course[index],String.valueOf(charArrays[j]),charArrays , j);
                }
            }
        }
        for(int i = 0 ; i<list.size() ; i++){
            map.put(list.get(i),map.getOrDefault(list.get(i),0)+1);
        }

        List<String> keyList = new ArrayList<>(map.keySet());
        ArrayList<String> temp = new ArrayList<>();
        Collections.sort(keyList , ((o1, o2) -> (map.get(o2).compareTo(map.get(o1))))); // o1 이 더 크면 true
        for(int i = 0 ; i<course.length ; i++){
            int max = 0;
            for(int  j = 0 ; j<keyList.size() ; j++){
                if(keyList.get(j).length()==course[i] &&  map.get(keyList.get(j))>=2){
                    if(max<=map.get(keyList.get(j))){
                        temp.add(keyList.get(j));
                        max = map.get(keyList.get(j));
                    }

                }
            }
        }
        Collections.sort(temp);
        answer = new String[temp.size()];
        temp.toArray(answer);
        return answer;
    }
    public void search(int course, String s, char[] arr, int index) {
        if(s.length() == course) {
            list.add(s);
        }
        for(int i = index+1; i<arr.length; i++) {
            search(course, s+String.valueOf(arr[i]), arr, i);
        }
    }
}
