public class main {
    public static void main(String[] args) {
        System.out.println("hello world!");
        System.out.println(ret_third_max(new int[]{1,1,2}));
    }


    public  static int ret_third_max(int[] nums){
        if(nums.length==1)
            return nums[0];
        if(nums.length==2)
            return Math.max(nums[0],nums[1]);
        int result1=nums[0];
//      遍历三轮，第一轮找出最大
        for (int num : nums) {
            if (result1 < num) {
                result1 = num;
            }
        }
//        第二轮找出第二大
//        先拿到除了第一大的随意一个元素
        Integer result2=null;
        for (int num:nums){
            if(num==result1)
                continue;
            result2=num;
        }
        if(result2==null)
            return result1;
        for(int num:nums){
            if(num==result1)
                continue;
            if(result2< num)
                result2=num;
        }
//        找到第三大元素
        Integer result3=null;
        for (int num:nums){
            if(num==result1||num==result2)
                continue;
            result3=num;
        }
        if(result3==null)
            return result1;
        for(int num:nums){
            if(num==result1||num==result2)
                continue;
            if(result3< num)
                result3=num;
        }




        return result3;
    }


}





