webpackJsonp([31],{195:function(e,t,n){function s(e){n(314)}var a=n(5)(n(244),n(347),s,null,null);e.exports=a.exports},244:function(e,t,n){"use strict";Object.defineProperty(t,"__esModule",{value:!0}),t.default={name:"message",data:function(){var e=this,t=function(t,n){return t("Button",{props:{size:"small"},on:{click:function(){e.hasreadMesList.unshift(e.currentMesList.splice(n.index,1)[0])}}},"标为已读")},n=function(t,n){return t("Button",{props:{size:"small",type:"error"},on:{click:function(){e.recyclebinList.unshift(e.hasreadMesList.splice(n.index,1)[0])}}},"删除")},s=function(t,n){return t("Button",{props:{size:"small"},on:{click:function(){e.hasreadMesList.unshift(e.recyclebinList.splice(n.index,1)[0])}}},"还原")};return{currentMesList:[],unreadMesList:[],hasreadMesList:[],recyclebinList:[],currentMessageType:"unread",showMesTitleList:!0,unreadCount:0,hasreadCount:0,recyclebinCount:0,noDataText:"暂无未读消息",mes:{title:"",time:"",content:""},mesTitleColumns:[{title:" ",key:"title",align:"left",ellipsis:!0,render:function(t,n){return t("a",{on:{click:function(){e.showMesTitleList=!1,e.mes.title=n.row.title,e.mes.time=e.formatDate(n.row.time),e.getContent(n.index)}}},n.row.title)}},{title:" ",key:"time",align:"center",width:200,render:function(t,n){return t("span",[t("Icon",{props:{type:"android-time",size:12},style:{margin:"0 5px"}}),t("span",{props:{type:"android-time",size:12}},e.formatDate(n.row.time))])}},{title:" ",key:"asread",align:"center",width:100,render:function(a,i){return"unread"===e.currentMessageType?a("div",[t(a,i)]):"hasread"===e.currentMessageType?a("div",[n(a,i)]):a("div",[s(a,i)])}}]}},methods:{formatDate:function(e){var t=new Date(e);return t.getFullYear()+"/"+(t.getMonth()+1)+"/"+t.getDate()+"  "+t.getHours()+":"+t.getMinutes()+":"+t.getSeconds()},backMesTitleList:function(){this.showMesTitleList=!0},setCurrentMesType:function(e){this.currentMessageType!==e&&(this.showMesTitleList=!0),this.currentMessageType=e,"unread"===e?(this.noDataText="暂无未读消息",this.currentMesList=this.unreadMesList):"hasread"===e?(this.noDataText="暂无已读消息",this.currentMesList=this.hasreadMesList):(this.noDataText="回收站无消息",this.currentMesList=this.recyclebinList)},getContent:function(e){var t="";switch(this.currentMessageType+e){case"unread0":t="这是您点击的《欢迎登录iView-admin后台管理系统，来了解他的用途吧》的相关内容。";break;case"unread1":t="这是您点击的《使用iView-admin和iView-ui组件库快速搭建你的后台系统吧》的相关内容。";break;case"unread2":t="这是您点击的《喜欢iView-admin的话，欢迎到github主页给个star吧》的相关内容。";break;case"hasread0":t="这是您点击的《这是一条您已经读过的消息》的相关内容。";break;default:t="这是您点击的《这是一条被删除的消息》的相关内容。"}this.mes.content=t}},mounted:function(){this.currentMesList=this.unreadMesList=[{title:"欢迎登录iView-admin后台管理系统，来了解他的用途吧",time:1507390106e3},{title:"使用iView-admin和iView-ui组件库快速搭建你的后台系统吧",time:1507390106e3},{title:"喜欢iView-admin的话，欢迎到github主页给个star吧",time:1507390106e3}],this.hasreadMesList=[{title:"这是一条您已经读过的消息",time:1507330106e3}],this.recyclebinList=[{title:"这是一条被删除的消息",time:1506390106e3}],this.unreadCount=this.unreadMesList.length,this.hasreadCount=this.hasreadMesList.length,this.recyclebinCount=this.recyclebinList.length},watch:{unreadMesList:function(e){this.unreadCount=e.length},hasreadMesList:function(e){this.hasreadCount=e.length},recyclebinList:function(e){this.recyclebinCount=e.length}}}},281:function(e,t,n){t=e.exports=n(168)(!0),t.push([e.i,".message-main-con{position:absolute;left:0;top:0;right:0;bottom:0}.message-mainlist-con{position:absolute;left:0;top:10px;width:300px;bottom:0;padding:10px 0}.message-mainlist-con div{padding:10px;margin:0 20px;border-bottom:1px dashed #d2d3d2}.message-mainlist-con div:last-child{border:none}.message-mainlist-con div .message-count-badge-outer{float:right}.message-mainlist-con div .message-count-badge{background:#d2d3d2}.message-mainlist-con div:first-child .message-count-badge{background:#ed3f14}.message-mainlist-con div .mes-type-btn-text{margin-left:10px}.message-content-con{position:absolute;top:10px;right:10px;bottom:10px;left:300px;background:#fff;border-radius:3px;box-shadow:2px 2px 10px 2px rgba(0,0,0,.1);overflow:auto}.message-content-con .message-title-list-con{width:100%;height:100%}.message-content-con .message-content-top-bar{height:40px;width:100%;background:#fff;position:absolute;left:0;top:0;border-bottom:1px solid #dededb}.message-content-con .message-content-top-bar .mes-back-btn-con{position:absolute;width:70px;height:30px;left:0;top:5px}.message-content-con .message-content-top-bar .mes-title{position:absolute;top:0;right:70px;bottom:0;left:70px;line-height:40px;padding:0 30px;white-space:nowrap;overflow:hidden;text-overflow:ellipsis;text-align:center}.message-content-con .mes-time-con{position:absolute;width:100%;top:40px;left:0;padding:20px 0;text-align:center;font-size:14px;color:#b7b7b5}.message-content-con .message-content-body{position:absolute;top:90px;right:0;bottom:0;left:0;overflow:auto}.message-content-con .message-content-body .message-content{padding:10px 20px}.back-message-list-enter,.back-message-list-leave-to{opacity:0}.back-message-list-enter-active,.back-message-list-leave-active{transition:all .5s}.back-message-list-enter-to,.back-message-list-leave{opacity:1}.view-message-enter,.view-message-leave-to{opacity:0}.view-message-enter-active,.view-message-leave-active{transition:all .5s}.view-message-enter-to,.view-message-leave{opacity:1}.mes-current-type-btn-enter,.mes-current-type-btn-leave-to{opacity:0;width:0}.mes-current-type-btn-enter-active,.mes-current-type-btn-leave-active{transition:all .3s}.mes-current-type-btn-enter-to,.mes-current-type-btn-leave{opacity:1;width:12px}","",{version:3,sources:["/Users/zhangyunlong/Downloads/my-project/src/page/message/message.vue"],names:[],mappings:"AACA,kBACE,kBAAmB,AACnB,OAAU,AACV,MAAS,AACT,QAAW,AACX,QAAY,CACb,AACD,sBACE,kBAAmB,AACnB,OAAQ,AACR,SAAU,AACV,YAAa,AACb,SAAU,AACV,cAAgB,CACjB,AACD,0BACE,aAAc,AACd,cAAe,AACf,gCAAkC,CACnC,AACD,qCACE,WAAa,CACd,AACD,qDACE,WAAa,CACd,AACD,+CACE,kBAAoB,CACrB,AACD,2DACE,kBAAoB,CACrB,AACD,6CACE,gBAAkB,CACnB,AACD,qBACE,kBAAmB,AACnB,SAAU,AACV,WAAY,AACZ,YAAa,AACb,WAAY,AACZ,gBAAkB,AAClB,kBAAmB,AACnB,2CAAgD,AAChD,aAAe,CAChB,AACD,6CACE,WAAY,AACZ,WAAa,CACd,AACD,8CACE,YAAa,AACb,WAAY,AACZ,gBAAkB,AAClB,kBAAmB,AACnB,OAAQ,AACR,MAAO,AACP,+BAAiC,CAClC,AACD,gEACE,kBAAmB,AACnB,WAAY,AACZ,YAAa,AACb,OAAQ,AACR,OAAS,CACV,AACD,yDACE,kBAAmB,AACnB,MAAO,AACP,WAAY,AACZ,SAAU,AACV,UAAW,AACX,iBAAkB,AAClB,eAAgB,AAChB,mBAAoB,AACpB,gBAAiB,AACjB,uBAAwB,AACxB,iBAAmB,CACpB,AACD,mCACE,kBAAmB,AACnB,WAAY,AACZ,SAAU,AACV,OAAQ,AACR,eAAgB,AAChB,kBAAmB,AACnB,eAAgB,AAChB,aAAe,CAChB,AACD,2CACE,kBAAmB,AACnB,SAAU,AACV,QAAS,AACT,SAAU,AACV,OAAQ,AACR,aAAe,CAChB,AACD,4DACE,iBAAmB,CACpB,AACD,qDAEE,SAAW,CACZ,AACD,gEAEE,kBAAoB,CACrB,AACD,qDAEE,SAAW,CACZ,AACD,2CAEE,SAAW,CACZ,AACD,sDAEE,kBAAoB,CACrB,AACD,2CAEE,SAAW,CACZ,AACD,2DAEE,UAAW,AACX,OAAS,CACV,AACD,sEAEE,kBAAoB,CACrB,AACD,2DAEE,UAAW,AACX,UAAY,CACb",file:"message.vue",sourcesContent:["\n.message-main-con {\n  position: absolute;\n  left: 0px;\n  top: 0px;\n  right: 0px;\n  bottom: 0px;\n}\n.message-mainlist-con {\n  position: absolute;\n  left: 0;\n  top: 10px;\n  width: 300px;\n  bottom: 0;\n  padding: 10px 0;\n}\n.message-mainlist-con div {\n  padding: 10px;\n  margin: 0 20px;\n  border-bottom: 1px dashed #d2d3d2;\n}\n.message-mainlist-con div:last-child {\n  border: none;\n}\n.message-mainlist-con div .message-count-badge-outer {\n  float: right;\n}\n.message-mainlist-con div .message-count-badge {\n  background: #d2d3d2;\n}\n.message-mainlist-con div:first-child .message-count-badge {\n  background: #ed3f14;\n}\n.message-mainlist-con div .mes-type-btn-text {\n  margin-left: 10px;\n}\n.message-content-con {\n  position: absolute;\n  top: 10px;\n  right: 10px;\n  bottom: 10px;\n  left: 300px;\n  background: white;\n  border-radius: 3px;\n  box-shadow: 2px 2px 10px 2px rgba(0, 0, 0, 0.1);\n  overflow: auto;\n}\n.message-content-con .message-title-list-con {\n  width: 100%;\n  height: 100%;\n}\n.message-content-con .message-content-top-bar {\n  height: 40px;\n  width: 100%;\n  background: white;\n  position: absolute;\n  left: 0;\n  top: 0;\n  border-bottom: 1px solid #dededb;\n}\n.message-content-con .message-content-top-bar .mes-back-btn-con {\n  position: absolute;\n  width: 70px;\n  height: 30px;\n  left: 0;\n  top: 5px;\n}\n.message-content-con .message-content-top-bar .mes-title {\n  position: absolute;\n  top: 0;\n  right: 70px;\n  bottom: 0;\n  left: 70px;\n  line-height: 40px;\n  padding: 0 30px;\n  white-space: nowrap;\n  overflow: hidden;\n  text-overflow: ellipsis;\n  text-align: center;\n}\n.message-content-con .mes-time-con {\n  position: absolute;\n  width: 100%;\n  top: 40px;\n  left: 0;\n  padding: 20px 0;\n  text-align: center;\n  font-size: 14px;\n  color: #b7b7b5;\n}\n.message-content-con .message-content-body {\n  position: absolute;\n  top: 90px;\n  right: 0;\n  bottom: 0;\n  left: 0;\n  overflow: auto;\n}\n.message-content-con .message-content-body .message-content {\n  padding: 10px 20px;\n}\n.back-message-list-enter,\n.back-message-list-leave-to {\n  opacity: 0;\n}\n.back-message-list-enter-active,\n.back-message-list-leave-active {\n  transition: all .5s;\n}\n.back-message-list-enter-to,\n.back-message-list-leave {\n  opacity: 1;\n}\n.view-message-enter,\n.view-message-leave-to {\n  opacity: 0;\n}\n.view-message-enter-active,\n.view-message-leave-active {\n  transition: all .5s;\n}\n.view-message-enter-to,\n.view-message-leave {\n  opacity: 1;\n}\n.mes-current-type-btn-enter,\n.mes-current-type-btn-leave-to {\n  opacity: 0;\n  width: 0;\n}\n.mes-current-type-btn-enter-active,\n.mes-current-type-btn-leave-active {\n  transition: all .3s;\n}\n.mes-current-type-btn-enter-to,\n.mes-current-type-btn-leave {\n  opacity: 1;\n  width: 12px;\n}\n"],sourceRoot:""}])},314:function(e,t,n){var s=n(281);"string"==typeof s&&(s=[[e.i,s,""]]),s.locals&&(e.exports=s.locals);n(169)("efe1a990",s,!0)},347:function(e,t){e.exports={render:function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"message-main-con"},[n("div",{staticClass:"message-mainlist-con"},[n("div",[n("Button",{attrs:{long:"",type:"text"},on:{click:function(t){e.setCurrentMesType("unread")}}},[n("transition",{attrs:{name:"mes-current-type-btn"}},[n("Icon",{directives:[{name:"show",rawName:"v-show",value:"unread"===e.currentMessageType,expression:"currentMessageType === 'unread'"}],attrs:{type:"checkmark"}})],1),n("span",{staticClass:"mes-type-btn-text"},[e._v("未读消息")]),n("Badge",{staticClass:"message-count-badge-outer",attrs:{"class-name":"message-count-badge",count:e.unreadCount}})],1)],1),e._v(" "),n("div",[n("Button",{attrs:{long:"",type:"text"},on:{click:function(t){e.setCurrentMesType("hasread")}}},[n("transition",{attrs:{name:"mes-current-type-btn"}},[n("Icon",{directives:[{name:"show",rawName:"v-show",value:"hasread"===e.currentMessageType,expression:"currentMessageType === 'hasread'"}],attrs:{type:"checkmark"}})],1),n("span",{staticClass:"mes-type-btn-text"},[e._v("已读消息")]),n("Badge",{staticClass:"message-count-badge-outer",attrs:{"class-name":"message-count-badge",count:e.hasreadCount}})],1)],1)]),e._v(" "),n("div",{staticClass:"message-content-con"},[n("transition",{attrs:{name:"view-message"}},[e.showMesTitleList?n("div",{staticClass:"message-title-list-con"},[n("Table",{ref:"messageList",attrs:{columns:e.mesTitleColumns,data:e.currentMesList,"no-data-text":e.noDataText}})],1):e._e()]),e._v(" "),n("transition",{attrs:{name:"back-message-list"}},[e.showMesTitleList?e._e():n("div",{staticClass:"message-view-content-con"},[n("div",{staticClass:"message-content-top-bar"},[n("span",{staticClass:"mes-back-btn-con"},[n("Button",{attrs:{type:"text"},on:{click:e.backMesTitleList}},[n("Icon",{attrs:{type:"chevron-left"}}),e._v("  返回")],1)],1),e._v(" "),n("h3",{staticClass:"mes-title"},[e._v(e._s(e.mes.title))])]),e._v(" "),n("p",{staticClass:"mes-time-con"},[n("Icon",{attrs:{type:"android-time"}}),e._v(" "+e._s(e.mes.time))],1),e._v(" "),n("div",{staticClass:"message-content-body"},[n("p",{staticClass:"message-content"},[e._v(e._s(e.mes.content))])])])])],1)])},staticRenderFns:[]}}});
//# sourceMappingURL=31.d5997138875cac132e63.js.map