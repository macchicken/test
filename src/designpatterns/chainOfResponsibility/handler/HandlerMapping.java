package designpatterns.chainOfResponsibility.handler;

enum HandlerMapping {

	SquadLeaderHandler(2),TeacherHandler(1),SchoolMasterHandler(0);

	private final int level;
	
	HandlerMapping(int level){
		this.level=level;
	}

	int getLevel() {
		return level;
	}

}
