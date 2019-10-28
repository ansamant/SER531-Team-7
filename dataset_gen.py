import xlsxwriter
import random
from shapely.geometry import Polygon, Point

# function to generate the random points
def get_random_point_in_rectangle(rect):
     min_x, min_y, max_x, max_y = rect.bounds
     while True:
         p = Point(random.uniform(min_x, max_x), random.uniform(min_y, max_y))
         if rect.contains(p):
             return p

r = Polygon([(40.761348, -73.977867), (40.761833, -73.977510), (40.760884, -73.976763), (40.761343, -73.976349)])

# dictionary to store the random points
result = {}

# generates 10000 points and stores them in result 
while len(result) != 10000:
  point_in_rect = get_random_point_in_rectangle(r)
  result[round(point_in_rect.x, 9)] = round(point_in_rect.y, 9)

print(len(result))
print(result)

# creates a demo file which has latitude & longitude as columns
with xlsxwriter.Workbook('demo.xlsx') as work_book:
    sheet = work_book.add_worksheet()
    sheet.write(0, 0, 'latitude')
    sheet.write(0, 1, 'longitude')
    for j, (key, value) in enumerate(result.items(), start=1):
        sheet.write(j, 0, key)
        sheet.write(j, 1, value)