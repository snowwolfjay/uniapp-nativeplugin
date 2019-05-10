/*
* author:yuhj
* email:snowwolfjay@foxmail.com 
* version:1.2
*/
const appkey="26037178";
const backUR=`tbopen${appkey}`;
const defD = {
	appkey,backURL,openApp: true,linkKey: 'TB', //"TM"。
	isNeedDownload: false, isDefaultRedirect: true
}
// #ifdef APP-PLUS 
import {
	core
} from "./core/plus.js"

class HJ_LBC  {
	#cw;
	#inited ;
	constructor(global,data){
		this.#cw = global.$mp.page.$getAppWebview();
		this.#cw.evalJS(core)
		this.#cw.evalJS('hj_lbc()')
		let o1 = JSON.stringify(Object.assign({},defD,data))
		this.#cw.evalJS('o1 =' + o1)
		this.#cw.evalJS('BC_SDK = BCSDK_AppLink.init(o1)')
		this.#inited = true;
		return this
	}
	toDetail(options){
		if(!this.#inited) return
		this.#cw.evalJS('o2 =' + JSON.stringify(options))
		this.#cw.evalJS('BC_SDK.goDetail(o2)')
	}
	toShop(options){
		if(!this.#inited) return
		this.#cw.evalJS('o2 =' + JSON.stringify(options))
		this.#cw.evalJS('BC_SDK.goShop(o2)')
	}
	toTaoke(options){
		if(!this.#inited) return
		this.#cw.evalJS('o2 =' + JSON.stringify(options))
		this.#cw.evalJS('BC_SDK.goTaoke(o2)')
	}
	toPage(options){
		if(!this.#inited) return
		this.#cw.evalJS('o2 =' + JSON.stringify(options))
		this.#cw.evalJS('BC_SDK.openPage(o2)')
	}
}
//#endif
// #ifdef H5
import {
	core
} from "./core/h5.js"
export class HJ_LBC  {
	#inited ;
	#ele;
	constructor(global,data){
		this.#ele =document.createElement('script')
		this.#ele.innerHTML = "eval("+")"
		return this
	}
	toDetail(options){
		
	}
	toDetail(options){
		
	}
}
// #endif
export default  HJ_LBC