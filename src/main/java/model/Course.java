package model;

public class Course {
	/**
	 * 课程名称:<input type="text" name="title"/><br>
		课程时长:<input type="text" name="duration"/><br>
		课程难度:<input type="text" name="level"/><br>
		课程介绍:<input type="text" name="descr"/><br>
	 * */
	private String title;
	private String duration;
	private String level;
	private String descr;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	@Override
	public String toString() {
		return "Course [title=" + title + ", duration=" + duration + ", level=" + level + ", descr=" + descr + "]";
	}	
}
