# 开发Java的准备
## 下载安装JDK
Java SE Development Kit,即Java标准版开发包,它提供了编译、运行Java程序所需的各种工具和资源.
例如下载jdk-8u121-windows-i586.exe文件,并进行安装。在安装时可以根据选项选择内容,例如选择是否安装公共JRE.(公共JRE是一个独立的JRE系统，会单独安装在系统的
其他路径下。公用JRE会向InternetExplorer浏览器和系统中注册java运行环境。通过这种方式，系统任何应用程序都可以使用公用JRE.)

## windows设置环境变量
"我的电脑"--->右键-->系统属性,或者按WINDOWS+Pause键,弹出系统设置界面.选择"高级系统设置"--->"环境变量"--->,在弹出的界面里的"系统变量"里面,点击"新建",新建变量名为:JAVA_HOME,变量值是:D:\java_dev\jdk1.8.0_121,(jdk1.8.0_121文件夹里面有bin,jre,lib,include等子文件夹),然后在"系统变量"里面的"Path"变量里面添加以下内容:
```txt
;%JAVA_HOME%\bin;%JAVA_HOME%\jre\bin;

```


