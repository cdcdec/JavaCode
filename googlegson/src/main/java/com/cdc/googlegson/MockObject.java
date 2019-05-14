package com.cdc.googlegson;
import com.google.gson.annotations.Expose;
public class MockObject{
    //其自身包含两个属性deserialize(反序列化)和serialize（序列化），默认都为true。
    @Expose//可以序列化  也可以反序列化
    public  int exposedField = 1;
    @Expose(serialize=true, deserialize=true)//可以序列化  也可以反序列化
    public  int explicitlyExposedField = 12;
    @Expose(serialize=false, deserialize=false)//不可以序列化  也不可以反序列化
    public  int explicitlyHiddenField = 2;
    @Expose(serialize=true, deserialize=false)//可以序列化  不可以反序列化
    public  int explicitlyDifferentModeField = 21;
    public  int hiddenField = 22;//不可以序列化  也不可以反序列化
}
