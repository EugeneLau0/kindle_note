# kindle note project

## 目的
该软件的产生灵感：主要来自个人长期使用 kindle 却无法导出辛辛苦苦做的笔记；

目的：开发该软件以帮助那些需要导出 kindle 笔记的朋友。 

## 使用方式
1. 将 kindle 中的 `My Clippings.txt` 文件拷贝到 `下载` 目录下；
2. 执行该软件，软件会到 `下载` 目录下去搜索 `My Clippings.txt` 文件；
3. 在应用程序界面选择一个书名，进行笔记生成；
4. 生成的笔记文件会直接放在 `下载` 目录下。

## 体验方式
1. 在 resources 目录下有一份 `My Clippings.txt` 文件，将其拷贝到 `下载` 目录下；
2. 按照[使用方式](#使用方式)的步骤操作即可。

## 待办
1. - [x] 文件解析成 Java 对象
2. - [x] Java 对象生成 Markdown 笔记文件
3. - [ ] Markdown 转 Word/PDF
4. - [ ] 增加 log 模块
5. - [ ] 增加 release：exe 应用程序，支持 Windows
6. - [ ] 增加 release：dmg 应用程序，支持 Mac
    
## 后记
如果有帮助到您，是我的荣幸！
如果有任何建议/问题，欢迎提 issue ！