# Essential mapper

Приложение для реализации и презитации EssentialMapper-a

EssentialMapper представляет возможность контроля за nullable параметрами в Response объектах и 
отправлять соответствующие отчёты в службы метрики:

Контроль осуществляется с помощью аннотации "@NotRequired"

Пример использовани EssentialMapper:

1)
val data: String?
В случае если приходит null, EssentialMapper обрабатывает данный факт и формирует отчёт вида:
""" 
Object -> SampleDTO(data=null)
Params -> data [null]
"""

2)
@NotRequired val data: String?
В случае если приходит null, EssentialMapper игнорирует данный факт.
