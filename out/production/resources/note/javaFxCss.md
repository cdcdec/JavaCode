# JavaFx Css

## 类型选择器（TypeSelector)
大部分JavaFX控件类都对应一个CSS Type，
我们可以使用类型选择器来控制类型控件的外观。对应的命名为:
将JavaFX的类名给改成首字母小写，如果有多个单词拼接的类名,
将每个单词原来大写的首字母小写然后用连字符将多个单词连接
Button -->button,CheckBox-->check-box

```
.label{
     -fx-text-fill:red
}

```

## 类选择器（Class selector)
类选择器可以应用到多个控件上，只要在相应的控件里加上StyleClass即可.
对于Node的任意子类都有一个getStyleClass 的方法，可以通过getStyleClass().add("background-color");
也可以在FXML文件上可以通过StyleClass标签添加background-color这个选择器的样式。类选择器会覆盖类型选择的样式。
```
.background-color{
     -fx-background-color:black;
}


```

## ID选择器
ID选择器由#开始进行定义，一个ID选择器对一个唯一一个控件
```
#ok-button{
   -fx-font-color:rgb(255,0,0,0);
   -fx-font-size:25px;
}
```

