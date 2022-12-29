package handler;

import domain.PagingVO;

public class PagingHandler {
	private int startpage;
	private int endPage;
	private boolean prev,next;
	private int totalCount;
	private PagingVO pgvo;
	
	public PagingHandler(PagingVO pgvo,int totalCount) {
		this.pgvo=pgvo;
		this.totalCount=totalCount;
		this.endPage=(int)Math.ceil(pgvo.getPageNo()/(pgvo.getQty()*1.0))*pgvo.getQty();
		this.startpage=this.endPage-(pgvo.getQty()-1);
		int realEndPage=(int)(Math.ceil((totalCount*1.0)/pgvo.getQty()));
		if(realEndPage<this.endPage) {
			this.endPage=realEndPage;
		}
		this.prev=this.startpage>1;
		this.next=this.endPage<realEndPage;
	}

	public int getStartpage() {
		return startpage;
	}

	public void setStartpage(int startpage) {
		this.startpage = startpage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public PagingVO getPgvo() {
		return pgvo;
	}

	public void setPgvo(PagingVO pgvo) {
		this.pgvo = pgvo;
	}
	
}