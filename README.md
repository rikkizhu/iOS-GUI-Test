#  iOS 自动化说明文档

## 搭建 appium iOS 环境
这一步很简单，可参考[此文章](https://juejin.im/post/5d7ef540f265da03bb4ada00)的【1 appnium 安装】【2 安装驱动】部分，最后用 appium-doctor 查看搭建是否 ok 就行了。

*注：我用的 appnium 是 1.13.0 版本，python 是 3.7.6  64位版本。*

## 真机驱动安装及 Xcode 配置

1. 安装 Xcode，我的是 10.3 版本，下载地址 https://developer.apple.com/download/more/
2. 找到 appnium WebDriverAgent 所在目录，如我的目录如下：
  - 终端 cd 到 /Applications/Appium.app/Contents/Resources/app/node_modules/appium/node_modules/appium-xcuitest-driver/WebDriverAgent 运行 `sh ./Scripts/bootstrap.sh`
  - 用 Xcode 打开 /Applications/Appium.app/Contents/Resources/app/node_modules/appium/node_modules/appium-xcuitest-driver/WebDriverAgent 下的如图所示文件
  
