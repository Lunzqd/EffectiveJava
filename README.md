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
 
 切记，每次写完一个equals方法，都要反思一下是否满足以上条件，都要写测试用例！不要自作聪明！
 
  **Item11: Always override hashCode when you override equals**
  
  **说明：** hashcode是一个重要的对象属性，与equals有着千丝万缕的联系，尤其是要将该对象存储到数组中时，hashcode在其中扮演着
  极其重要的角色。譬如，当用户需要存储对象到hashset或hashmap中的时候，系统会首先判断用户的hashcode，如果一致，那么系统会
  去调用equals方法，如果一致，则不允许存储
  
  所以，是否重写hashcode需要看系统对该对象的需求，如果仅仅用来比较大小，但是就是认为这是两个对象，那么可以不重写hashcode，否则
  就应该重写hashcode，尤其是要将对象存储到数组中，而且对数组有排列或去重的要求时
  
   
 **Item12: Always override toString**
  
  **说明：** 建议Pojo对象全部重写toString方法，在该方法中只需要返回Json就可以。因为，为了能够正常运维，系统一定需要记录相关的
  操作日志，这些日志中需要将必须的传递值携带上，此时，在我们记录日志时，我们可能会写String.format("value:%s",obj)，此时，系统
  就会调用该方法的toString()方法
  
 **Item14: Consider implementing Comparable**
    
**说明：** 如果对象需要有比较大小的需求，或者对象需要存储到数组中并且根据大小排序，那么一定要实现Comparable接口

**需要遵循的特性：**
 
 **1：自反性：** x.compare(x) must return 0
 
 **2：对称性：** x.compare(y) == -y.compare(x)
 
 **3：传递性：** if x.compare(y) returns >0 and y.equals(z) returns >0, then x.equals(z) must return >0.???
 
 **4：一致性：** x.compare(y) must consistently return true or consistently return false
 
 **5：Null判断：** x.compare(null) must return >0, 但是用户应该在初始化对象时就规避这种问题，即比较因子应该在创建对象时
 进行必填校验
 
 **6：Have Exception：** x.compare(y) allows to throw exception
 
 **6：equals：** if x.compare(y)==0 then x.equals(y)==true