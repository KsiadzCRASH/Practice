import re

with open('D:/4 - A.I_DX9_DX10/TF - AI 2.0/PY_DEV_START/scratch.html', "r", encoding="utf-8") as file:
    print("Start reading")
    lines = file.readlines()
output = ''
for line in lines:
    output += re.sub(r"<.*?>", '', line)
print(output)

with open('D:/4 - A.I_DX9_DX10/TF - AI 2.0/PY_DEV_START/task.txt', "w+", encoding="utf-8") as file:
    file.write(output)

