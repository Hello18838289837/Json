package com.java.array;

/**
 *   数组的复习:
 *       数组:用来存储同一种元素的集合
 *       特点:
 *          A:元素的类型一致
 *          B:元素有整数的索引
 *          C:一旦定义好长度则无法改变
 *          D:可以存储基本数据类型
 *          E:也可以存储引用数据类型
 * 数组的定义格式:
 *          A:动态初始化
 *             数据类型[] 数组名 = new 数据类型[数组长度]
 *          B:静态初始化标志定义
 *             数据类型[] 数组名 = new 数据类型[]{元素1,元素2,.......}
 *          C:静态初始化的简化写法   
 *             数据类型[] 数组名 = {元素1,元素2,.......}
 * @author Mr.振
 *的发射点发射点发射点
 */
public class ReviewArray {
       public static void main(String[] args) {
		    int[] array = {1,2,3,4,5};
		    int sum = 0;
		    for(int i=0;i<array.length;i++) {
		    	sum+=array[i];
		    	
		    }
		    System.out.println(sum);
	}
}
