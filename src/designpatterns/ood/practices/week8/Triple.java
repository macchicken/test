package designpatterns.ood.practices.week8;

class Triple {

	private static Triple[] instance=new Triple[3];// directly initialize the Triple objects along this static statement using classloader strategy, avoid most of thread issues
	static{
		instance[0]=new Triple();
		instance[1]=new Triple();
		instance[2]=new Triple();
	}
	
	private Triple(){}
	
	static Triple getInstance(int id){return instance[id];}
	static Triple getInstance(){return instance[0];}

}
