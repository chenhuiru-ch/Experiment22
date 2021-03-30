package bao;
import java.text.NumberFormat;
import java.util.Arrays;

/**
任务3-3
能够对一组D{0-1}KP数据按项集第三项的价值:重量比进行非递增排序
 **/
public class WeightRatio {

	public static void main(String[] args) {

		//定义profit和weight数组
		int[] profit = {408,921,1329,11,998,1009,104,839,943,299,374,673,703,954,1657,425,950,1375,430,541,971,332,483,815,654,706,1360,956,992,1948}; //new int[]方框里不能指定长度
		int[] weight = {508,1021,1321,111,1098,1196,204,939,1107,399,474,719,803,1054,1781,525,1050,1362,530,641,903,432,583,894,754,806,1241,1056,1092,1545};
		//定义比值ratio
		double[] ratio = new double[profit.length];
			
		for(int i = 0;i<profit.length;i++){
			if(weight[i] == 0){
				return;
			}
			
			double s = (double)profit[i]/weight[i];//强制转换类型
			NumberFormat result = NumberFormat.getNumberInstance();//java格式化数字
			result.setMaximumFractionDigits(5);//小数点后保留5位
			int[] ins = new int[100000];
			ratio[i]=s;
		}
		
		//冒泡排序
		double tmp;
		for (int a= 1; a < ratio.length; a++) {
			for (int j = 0; j < ratio.length-1; j++) {
				if(ratio[j] < ratio[j+1]){
					tmp = ratio[j];
					ratio[j] = ratio[j+1];
					ratio[j+1] = tmp;
				}
			}
		}
		System.out.println("重量比为：");
		for(int b=0;b<ratio.length;b++) {
			System.out.println(ratio[b]);
		}
	}
}
