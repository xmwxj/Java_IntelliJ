package com.designPattern.CreatePattern;

/**
 *
 * @author Nansen
 * 原型模式
 * 一个对象作为原型，使用clone()方法来创建新的实例。
 */
public class Protype {
	public static class Prototype implements Cloneable {

		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@SuppressWarnings("finally")
		@Override
		protected Object clone() {
			try {
				return super.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			} finally {
				return null;
			}
		}

		public static void main(String[] args) {
			Prototype pro = new Prototype();
			Prototype pro1 = (Prototype) pro.clone();
		}
	}
}
