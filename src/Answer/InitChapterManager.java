package Answer;

import chapter1.Chapter1_1Creative;
import chapter1.Chapter1_1Exercises;
import chapter1.Chapter1_1Experiments;
import chapter1.Chapter1_2Exercises;
import chapter1.Chapter1_3Exercises;
import chapter1.Chapter1_3ListExercises;
import chapter1.Chapter1_4Exercises;
import framework.ExerciseManager;

/**
 * 习题初始化管理器
 * */
public class InitChapterManager {

	private ExerciseManager exerciseManager = ExerciseManager.getInstence();
	
	public void init(){
		exerciseManager.regiestQuestion(new Chapter1_1Exercises());  //通过注册方法，将习题类中的习题通知给习题管理器
		exerciseManager.regiestQuestion(new Chapter1_1Creative()); 
		exerciseManager.regiestQuestion(new Chapter1_1Experiments()); 
		exerciseManager.regiestQuestion(new Chapter1_2Exercises()); 
		exerciseManager.regiestQuestion(new Chapter1_3Exercises()); 
		exerciseManager.regiestQuestion(new Chapter1_3ListExercises()); 
		exerciseManager.regiestQuestion(new Chapter1_4Exercises()); 
	}
	
	
	//单例
	public static InitChapterManager getInstance(){
		return InitChapterManagerHolder.initChapterManager;
	}
	
	private static class InitChapterManagerHolder{
		private static InitChapterManager initChapterManager = new InitChapterManager();
	}
}
