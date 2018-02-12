import pygal

pie_chart=pygal.Pie()
pie_chart.tile="Abhi"
pie_chart.add('Positive Audio',20)
pie_chart.add('Positive Video',30)
pie_chart.add('Negative Audio',30)
pie_chart.add('Negative Video',20)
pie_chart.render()

