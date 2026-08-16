@echo off
chcp 65001 >nul
title 推送 E 仓库

echo ========================================
echo   推送当前仓库
echo   路径: %cd%
echo ========================================
echo.

:: 检查 Git
git --version >nul 2>nul
if errorlevel 1 (
    echo [错误] 未安装 Git！
    pause
    exit /b
)

:: 检查 .git
if not exist ".git" (
    echo [警告] 不是 Git 仓库，正在初始化...
    git init
    git remote add origin https://github.com/bii20081Aztec/Electrical-appliances-and-lamps
    echo 初始化完成！
    pause
)

:: 正常推送（无 --delete，无 --force）
echo [1/3] 添加文件...
git add .

echo [2/3] 提交更改...
git commit -m "更新 %date:~0,4%-%date:~5,2%-%date:~8,2%"

echo [3/3] 推送到远程...
git push -u origin main

if errorlevel 1 (
    echo [提示] main 分支失败，尝试 master...
    git push -u origin master
)

echo.
echo ========================================
echo   推送完成！
echo ========================================
pause