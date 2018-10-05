package kr.itedu.board;

public class CommentVO {
	private int bid;
	private int cid;
	private int btype;
	private String t_comment;
	private String cregdate;
	
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getBtype() {
		return btype;
	}
	public void setBtype(int btype) {
		this.btype = btype;
	}
	public String getT_comment() {
		return t_comment;
	}
	public void setT_comment(String t_comment) {
		this.t_comment = t_comment;
	}
	public String getCregdate() {
		return cregdate;
	}
	public void setCregdate(String cregdate) {
		this.cregdate = cregdate;
	}
}
