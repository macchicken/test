package designpatterns.chainOfResponsibility;

import java.util.Random;

import designpatterns.chainOfResponsibility.handler.ProcessHandlerFacade;
import designpatterns.chainOfResponsibility.handler.Student;

class Client {

	public static void main(String[] args) {
		ProcessHandlerFacade facadeService=ProcessHandlerFacade.getInstance();
		facadeService.addHandler("SquadLeaderHandler");
		facadeService.addHandler("TeacherHandler");
		facadeService.addHandler("SchoolMasterHandler");
		Random random=new Random();
		Student[] students=new Student[3];
		for (int i=0;i<3;i++){
			students[i]=new Student(random.nextInt(3)," i am student "+(i+1)+", i need a day off.");
		}
		for (int i=0;i<3;i++){
			facadeService.sendRequest(students[i]);
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		facadeService.resetHandler();
		System.out.println();
		facadeService.addHandler("SchoolMasterHandler");// change the chain of handler
		facadeService.addHandler("TeacherHandler");
		facadeService.addHandler("SquadLeaderHandler");
		for (int i=0;i<3;i++){
			facadeService.sendRequest(students[i]);
		}
	}

}
