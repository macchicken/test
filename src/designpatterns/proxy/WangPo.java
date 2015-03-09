package designpatterns.proxy;

public class WangPo implements KindWoman {

	private KindWoman kindWoman;

	public WangPo() {
		super();
		this.kindWoman = new PanJinLian();
	}

	public WangPo(String name) {
		super();
		if ("JiaShi".equals(name)){
			this.kindWoman = new JiaShi();
		}else if ("PanJinLian".equals(name)){
			this.kindWoman = new PanJinLian();
		}
	}

	@Override
	public void makeEyesWithMan() {
		if (kindWoman!=null) {
			this.kindWoman.makeEyesWithMan();
		}
	}

	@Override
	public void happyWithMan(int price) {
		if (kindWoman!=null) {
			if (this.kindWoman instanceof PanJinLian) {
				if (price <= 499) {return;}
			} else if (this.kindWoman instanceof JiaShi) {
				if (price <= 699) {return;}
			}
			this.kindWoman.happyWithMan(price);
		}
	}

}
