```flow
st=>start: 推送
io=>inputoutput: 消息
cd1=>condition: Lite App展示页面是否存在
openH5=>operation: 打开Lite App展示页面
sub=>subroutine: 页面内部逻辑
cd2=>condition: 推送消息所属的H5应用是否正在展示
passLiteApp=>operation: 传递消息给Lite App
liteAppList=>operation: 查询Lite App预加载列表
cd3=>condition: 推送消息所属的H5应用是否存在
show2pass=>operation: 展示Lite App并传递消息
add2pass=>operation: 添加Lite App
e=>end: Lite App 内部逻辑

st->io->cd1
cd1(yes)->sub
cd1(no)->openH5
openH5->sub
sub->cd2
cd2(yes)->passLiteApp
cd2(no)->liteAppList
liteAppList->cd3
cd3(yes)->show2pass
cd3(no)->add2pass->show2pass(left)->e
passLiteApp->e

```