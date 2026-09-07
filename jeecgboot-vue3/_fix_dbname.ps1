# 临时脚本：将后端各配置中 MySQL 主库名统一改为 jeecg_boot（UTF-8 无 BOM 读写）
$ErrorActionPreference = 'Stop'
$utf8NoBom = New-Object System.Text.UTF8Encoding($false)

$targets = @(
    @{ File = 'D:\260901\Attendance Management System\jeecg-boot\jeecg-module-system\jeecg-system-start\src\main\resources\application-test.yml';
       Old = '127.0.0.1:3306/jeecg-boot?'; New = '127.0.0.1:3306/jeecg_boot?' },
    @{ File = 'D:\260901\Attendance Management System\jeecg-boot\jeecg-module-system\jeecg-system-start\src\main\resources\application-prod.yml';
       Old = '127.0.0.1:3306/jeecg-boot?'; New = '127.0.0.1:3306/jeecg_boot?' },
    @{ File = 'D:\260901\Attendance Management System\jeecg-boot\jeecg-module-system\jeecg-system-start\src\main\resources\application-docker.yml';
       Old = 'jeecg-boot-mysql:3306/jeecg-boot?'; New = 'jeecg-boot-mysql:3306/jeecg_boot?' },
    @{ File = 'D:\260901\Attendance Management System\jeecg-boot\jeecg-module-system\jeecg-system-start\src\main\resources\jeecg\jeecg_database.properties';
       Old = 'jeecg-boot'; New = 'jeecg_boot' },
    @{ File = 'D:\260901\Attendance Management System\jeecg-boot\jeecg-server-cloud\jeecg-system-cloud-start\src\main\resources\jeecg\jeecg_database.properties';
       Old = 'jeecg-boot'; New = 'jeecg_boot' },
    @{ File = 'D:\260901\Attendance Management System\jeecg-boot\jeecg-boot-module\jeecg-boot-module-airag\src\main\resources\application.yml';
       Old = 'localhost:3306/jeecg-boot-dev?'; New = 'localhost:3306/jeecg_boot?' },
    @{ File = 'D:\260901\Attendance Management System\jeecg-boot\jeecg-server-cloud\jeecg-cloud-nacos\docs\DEFAULT_GROUP\jeecg-dev.yaml';
       Old = 'jeecg-boot-mysql:3306/jeecg-boot?'; New = 'jeecg-boot-mysql:3306/jeecg_boot?' },
    @{ File = 'D:\260901\Attendance Management System\jeecg-boot\jeecg-server-cloud\jeecg-cloud-nacos\docs\DEFAULT_GROUP\jeecg-dev-satoken.yaml';
       Old = 'jeecg-boot-mysql:3306/jeecg-boot?'; New = 'jeecg-boot-mysql:3306/jeecg_boot?' },
    @{ File = 'D:\260901\Attendance Management System\jeecg-boot\jeecg-server-cloud\jeecg-cloud-nacos\docs\DEFAULT_GROUP\sharding.yaml';
       Old = 'jeecg-boot-mysql:3306/jeecg-boot?'; New = 'jeecg-boot-mysql:3306/jeecg_boot?' }
)

foreach ($t in $targets) {
    $text = [System.IO.File]::ReadAllText($t.File)
    $count = ([regex]::Matches($text, [regex]::Escape($t.Old))).Count
    if ($count -eq 0) { Write-Output "SKIP (no match): $($t.File)"; continue }
    $newText = $text.Replace($t.Old, $t.New)
    [System.IO.File]::WriteAllText($t.File, $newText, $utf8NoBom)
    Write-Output "OK ($count replaced): $($t.File)"
}
