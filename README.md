# EffectiveJava

**Section 1：对象的创建及销毁**

**Item 1: Consider static factory methods instead of constructors**
 
 **优点：**
 * 1：它们有名字
 * 2：不像构造函数，每次使用对象时都需要调用构造函数
 * 3：他可以实现适配的作用，即通过该方法实现相关对象之间的相互转换
 * 4：可是实现对象的基本检查，不用担心返回的对象因为属性不足而无法使用
 * 5：可以实现单例模式
 
 **不足：**
 * 1：不推荐在bean中使用，因为java bean的生成必须要有空的构造函数，而一旦该方法用以生成单例，那么他就不会有无参构造函数
 * 2：不方便编程，不知道哪些类通过该方式生成对象
 
 一般用来做关联的对象之间的转换或构造
 
 • **from**—A type-conversion method that takes a single parameter and returns a
 corresponding instance of this type, for example:
    Date d = Date.from(instant);
    
 • **of**—An aggregation method that takes multiple parameters and returns an instance
 of this type that incorporates them, for example:
    Set<Rank> faceCards = EnumSet.of(JACK, QUEEN, KING);
    
 • **valueOf**—A more verbose alternative to from and of, for example:
    BigInteger prime = BigInteger.valueOf(Integer.MAX_VALUE);
    
 • **instance or getInstance**—Returns an instance that is described by its parameters
 (if any) but cannot be said to have the same value, for example:
    StackWalker luke = StackWalker.getInstance(options);
    
 • **create or newInstance**—Like instance or getInstance, except that the
 method guarantees that each call returns a new instance, for example:
    Object newArray = Array.newInstance(classObject, arrayLen);
    
 • **getType**—Like getInstance, but used if the factory method is in a different
 class. Type is the type of object returned by the factory method, for example:
    FileStore fs = Files.getFileStore(path);
    
 • **newType**—Like newInstance, but used if the factory method is in a different
 class. Type is the type of object returned by the factory method, for example:
    BufferedReader br = Files.newBufferedReader(path);
    
 • **type**—A concise alternative to getType and newType, for example:
    List<Complaint> litany = Collections.list(legacyLitany);
 
 
 **Item 2: Consider a builder when faced with many constructor
 parameters**
 
 考虑使用Builder来构建多构造参数的对象
 
 **优点**
 1：可以强制输入保证对象运行所必须的参数
 2：只有输入完参数且完成校验后才能够生成对象，保证高效
 
 **不足**
 1：不能用在Java Bean中
 
 **实现方式：**
 在主类中构建一个内部类- Builder，用户通过向该Builder传递参数而构建一个主类的对象
 
 **Section2 对象通用方法**
 
 **Item10: Obey the general contract when overriding equals**
 
 **用途：** 当用户有特殊需求，即对象之间的比较不通过传统的reference，而是通过具体的属性来比较
 
 **需要遵循的特性：**
 
 **1：自反性：** x.equals(x) must return true
 
 **2：对称性：** x.equals(y) must return true if and only if y.equals(x) returns true.
 
 **3：传递性：** if x.equals(y) returns true and y.equals(z) returns true, then x.equals(z) must return true.
 
 **4：一致性：** x.equals(y) must consistently return true or consistently return false
 
 **5：Null判断：** x.equals(null) must return false
 
 **6：No Exception：** x.equals(y) should not throw exception