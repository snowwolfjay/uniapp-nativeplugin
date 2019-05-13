
## 原生插件通用使用流程：
####1.购买插件，选择该插件绑定的项目。
####2.在HBuilderX里找到项目，在manifest的app原生插件配置中勾选模块，如需要填写参数则参考插件作者的文档添加。
####3.根据插件作者的提供的文档开发代码，在代码中引用插件，调用插件功能。
####4.打包自定义基座，选择插件，得到自定义基座，然后运行时选择自定义基座，进行log输出测试。
####5.开发完毕后正式云打包
####付费原生插件目前不支持离线打包。
####Android 离线打包原生插件另见文档 https://ask.dcloud.net.cn/article/35763
####iOS 离线打包原生插件另见文档 https://ask.dcloud.net.cn/article/35764

## HJ-AliBC简介：
#### 以百川的免费电商SDK为基础，开发的可用于uniapp继承的版本。可实现跳转到淘宝进行登录，并返回用户数据等
>#### 现已将代码开源,包括js-sdk和安卓sdk，其它改进还在进行中 [百川SDK-UniAPP版本](https://github.com/snowwolfjay/uniapp-nativeplugin/tree/master/alibc)
>#### 由于是第一次进行JAVA开发，还希望大佬们多给点指点，或者共同修改。

## 使用教程：
### 引入方式
#### ``` const hjAlibc = uni.requireNativePlugin('HJ-AliBC'); ```

### API：
>#### init(callback) :
>#### callback返回参数：Object；
>####｛success:Bollean,data:“描述”｝
>#### tips:插件加载时会默认进行初始化，如果已经初始化成功，则调用本API会失败，返回“重复的初始化”data字符串

>#### login(callback) :
>#### callback返回参数：Object；
>####｛success:Bollean,data:String|JSONString｝
>#### tips:success为true时，可用JSON.parse解析用户数据为js对象；

### 安全图片：
>#### 项目目录下新建nativeplugins/HJ-AliBC/android/res/drawable目录，然后将百川后台获取的yw_1222.jpg放入其中；
>#### 离线打包测试github项目模板时，安全图片如果要更改，请注意修改下各个配置，参考离线打包的配置；

### 使用示例
```
<template>
	<view class="button-sp-area">
		<button type="primary" plain="true" @click="init">初始化</button>
		<button type="primary" plain="true" @click="login">登录</button>
	</view>
</template>

<script>
	const hjAlibc = uni.requireNativePlugin('HJ-AliBC');

	export default {
		data() {
			return {
				title: ''
			}
		},
		onLoad() {

		},
		methods: {
			init() {
				hjAlibc.init(res => uni.showToast({
					title: JSON.stringify(res),
					mask: false,
					duration: 1500
				}))
			},
			login() {
				hjAlibc.login(res => {
					if (res.success) {
						uni.showToast({
							title: res.data,
							mask: false,
							duration: 1500
						})
					}
				})
			}
		}
	}
</script>

<style>
	button {
		margin-top: 30upx;
		margin-bottom: 30upx;
	}

	.button-sp-area {
		margin: 0 auto;
		width: 60%;
	}

	.content {
		text-align: center;
		height: 400upx;
	}

	.wrapper {
		flex-direction: column;
		justify-content: center;
	}

	.button {
		width: 200px;
		margin-top: 30px;
		margin-left: 20px;
		padding-top: 20px;
		padding-bottom: 20px;
		border-width: 2px;
		border-style: solid;
		border-color: #458B00;
		background-color: #458B00;
	}

	.text {
		font-size: 30px;
		color: #666666;
		text-align: center;
	}
</style>
```