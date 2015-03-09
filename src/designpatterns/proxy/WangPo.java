package designpatterns.proxy;

public class WangPo implements KindWoman {

	private KindWoman kindWoman;

	public WangPo() {
		super();
		this.kindWoman = new PanJinLian();
	}

	public WangPo(KindWoman kindWoman) {
		super();
		this.kindWoman = kindWoman;
	}

	@Override
	public void makeEyesWithMan() {
		this.kindWoman.makeEyesWithMan();
	}

	@Override
	public void happyWithMan(int price) {
		if (this.kindWoman instanceof PanJinLian){
			if (price<=499){return;}
		}else if (this.kindWoman instanceof JiaShi){
			if (price<=699){return;}
		}
		this.kindWoman.happyWithMan(price);
	}

}
