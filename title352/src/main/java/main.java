import java.util.*;

public class main {
    public static void main(String[] args) {
        System.out.println("返回不交叉区间");
        SummaryRanges summaryRanges=new SummaryRanges();
        summaryRanges.addNum(1);
        summaryRanges.addNum(2);
        summaryRanges.addNum(3);
        summaryRanges.addNum(6);
        summaryRanges.addNum(7);

        /*
        输入：
["SummaryRanges", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals"]
[[], [1], [], [3], [], [7], [], [2], [], [6], []]
输出：
[null, null, [[1, 1]], null, [[1, 1], [3, 3]], null, [[1, 1], [3, 3], [7, 7]], null, [[1, 3], [7, 7]], null, [[1, 3], [6, 7]]]

解释：
SummaryRanges summaryRanges = new SummaryRanges();
summaryRanges.addNum(1);      // arr = [1]
summaryRanges.getIntervals(); // 返回 [[1, 1]]
summaryRanges.addNum(3);      // arr = [1, 3]
summaryRanges.getIntervals(); // 返回 [[1, 1], [3, 3]]
summaryRanges.addNum(7);      // arr = [1, 3, 7]
summaryRanges.getIntervals(); // 返回 [[1, 1], [3, 3], [7, 7]]
summaryRanges.addNum(2);      // arr = [1, 2, 3, 7]
summaryRanges.getIntervals(); // 返回 [[1, 3], [7, 7]]
summaryRanges.addNum(6);      // arr = [1, 2, 3, 6, 7]
summaryRanges.getIntervals(); // 返回 [[1, 3], [6, 7]]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/data-stream-as-disjoint-intervals
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         */
    }
}
class SummaryRanges {
    Set<Integer> hashSet=new HashSet<>();
    public SummaryRanges() {

    }

    public void addNum(int val) {
        hashSet.add(val);
    }

    public int[][] getIntervals() {
        List<List<Integer>> list=new ArrayList<>();
        //对hashset进行排序
        Object[] cur_arr=hashSet.stream().sorted().toArray();
        for (int i = 0; i < cur_arr.length; i++) {
            Integer cur_num=(Integer) cur_arr[i];
            System.out.println("cur_num:"+cur_num);
            List<Integer> tmp=new ArrayList<>();
            if(i==hashSet.size()-1){
                tmp.add(cur_num);tmp.add(cur_num);
                list.add(tmp);
                break;
            }else{
                Integer left=cur_num;
                Integer right=cur_num;
                while (i<cur_arr.length-1&&cur_num+1==(Integer)cur_arr[i+1]){
                    cur_num=(Integer)cur_arr[i+1];
                    right=(Integer)cur_arr[i+1];
                    i++;
                }
                if(Objects.equals(left, right)){
                    tmp.add(left);tmp.add(right);
                    list.add(tmp);
                }else{
                    //不等
                    tmp.add(left);tmp.add(right);
                    list.add(tmp);
                }
            }


        }
        int[][] result=new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < 2; j++) {
                result[i][j]=list.get(i).get(j);
            }
        }

        return result;
    }
}
