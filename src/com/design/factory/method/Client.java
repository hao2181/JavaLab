package com.design.factory.method;

/**
 *优缺点：
    可以在不知具体实现的情况下编程
        工厂方法模式可以让你在实现功能的时候，如果需要某个产品对象，只需要使用产品的接口即可，而无需关心具体的实现。选择具体实现的任务延迟到子类去完成。
    更容易扩展对象的新版本
        工厂方法给子类提供了一个挂钩，使得扩展新的对象版本变得非常容易。比如上面示例的参数化工厂方法实现中，扩展一个新的导出Xml文件格式的实现，已有的代码都不会改变，只要新加入一个子类来提供新的工厂方法实现，然后在客户端使用这个新的子类即可。
        另外这里提到的挂钩，就是我们经常说的钩子方法(hook)，这个会在后面讲模板方法模式的时候详细点说明。
    连接平行的类层次
        工厂方法除了创造产品对象外，在连接平行的类层次上也大显身手。这个在前面已经详细讲述了。
    具体产品对象和工厂方法的耦合性
        在工厂方法模式里面，工厂方法是需要创建产品对象的，也就是需要选择具体的产品对象，并创建它们的实例，因此具体产品对象和工厂方法是耦合的。

 * @author Administrator
 *
 */
//工厂方法模式的本质：延迟到子类来选择实现。
public class Client {
	
	public static void main(String[] args) {
		Creator api = new DbExportCreator();
		api.export("fuck");
		new Client.Inner();
	}
	
	private static class Inner{
		public Inner(){
			System.out.println("Inner class init");
		}
	}
}
