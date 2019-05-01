# JMORE 框架

         _   .-')                _  .-')     ('-.
        ( '.( OO )_             ( \( -O )  _(  OO)       ,-.,-.,-.
     ,--.,--.   ,--.).-'),-----. ,------. (,------.       \ \\ \\ \
 .-')| ,||   `.'   |( OO'  .-.  '|   /`. ' |  .---'        \ \\ \\ \
( OO |(_||         |/   |  | |  ||  /  | | |  |             \ \\ \\ \
| `-'|  ||  |'.'|  |\_) |  |\|  ||  |_.' |(|  '--.          / // // /
,--. |  ||  |   |  |  \ |  | |  ||  .  '.' |  .--'         / // // /
|  '-'  /|  |   |  |   `'  '-'  '|  |\  \  |  `---.       / // // /
 `-----' `--'   `--'     `-----' `--' '--' `------'      `-'`-'`-'


## 架构组件

-[ ] 基础框架层(jmore-framework)
-[ ] 分布式锁(jmore-lock)
-[ ] 数据操作组件(jmore-data)
-[ ] 消息总线组件(jmore-eventbus)
-[ ] 分布式事务解决方案(jmore-transaction)
-[ ] 控制台组件(jmore-console)
-[ ] WEB组件(jmore-web)
-[ ] 限流组件(jmore-concurrency-limit)

-[ ] DDD领域项目脚手架组件(jmore-ddd-structure)

## 架构图



## 约定

对前后端交互格式做约定化配置。

### API JSON 格式

后端通讯全部以`POST`形式传递

#### 成功消息体

```json
{
  "code": 0,
  "timestamp": 1524640724522,
  "msg": "成功",
  "data": ["label"]
}
```

```json
{
  "code": 0,
  "timestamp": 1524640724522,
  "msg": "成功",
  "data": {
    "name": "jmore"
  }
}
```

#### 失败消息体

```json
{
  "code": -1010,
  "timestamp": 1524640724522,
  "msg": "获取失败",
  "data": null
}
```

