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
