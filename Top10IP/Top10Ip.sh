#!/bin/bash
#ͳ����־�ļ��з��ʴ���ǰ10��IP����Ӧ����
ip=$(cat $a | grep -E -o "([0-9]{1,3}[\.]){3}[0-9]{1,3}" |sort|uniq -c|sort -k 1 -n -r|
		awk '{print NR"\t"$b"\t"$a}') 
if [ $# -eq 2 ];then
    echo -e "���\tip\t\t����">$b
    echo "$ip">>$b
  else 
    echo -e "���\tip\t\t����"      
    echo "$ip"
fi
