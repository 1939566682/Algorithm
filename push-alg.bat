@echo off
:: 基础配置（解决乱码+路径兜底）
chcp 65001 >nul
set LC_ALL=zh_CN.UTF-8
set LANG=zh_CN.UTF-8
cd /d E:\Idea_workscope\Algorithm

:: 拉取远程最新代码
git pull Algorithm-Gitee main
git pull Algorithm-GitHub main

:: 交互式输入提交信息（英文提示无乱码）
set /p commit_msg=Please enter commit message for algorithm project: 

:: 提交+推送核心逻辑
git add .
git commit -m "%commit_msg%"
git push Algorithm-Gitee main
git push Algorithm-GitHub main

:: 执行结果提示
echo.
echo ==============================
echo Algorithm project pushed successfully!
echo ==============================
pause