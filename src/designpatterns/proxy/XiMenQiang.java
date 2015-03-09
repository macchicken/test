package designpatterns.proxy;

public class XiMenQiang {

	public static void main(String[] args) {
		WangPo wangPo = new WangPo();// could only initial the PROXY
		wangPo.makeEyesWithMan();
		wangPo.happyWithMan(500);
		wangPo = new WangPo(new JiaShi());
		wangPo.makeEyesWithMan();
		wangPo.happyWithMan(500);
	}

}
