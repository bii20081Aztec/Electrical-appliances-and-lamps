@echo off
chcp 65001 >nul

echo ========================================
echo   删除远程 master 分支
echo ========================================
echo.

echo [1/2] 设置远程地址...
git remote add origin https://github.com/bii20081Aztec/Electrical-appliances-and-lamps 2>nul
echo.

echo [2/2] 删除远程 master 分支...
git push origin --delete master
if errorlevel 1 (
    echo 远程没有 master 分支，或删除失败。
) else (
    echo 远程 master 分支已删除！
)

echo.
echo ========================================
echo   完成！刷新 GitHub 页面查看。
echo ========================================
pause