import pandas as pd
from IPython.display import display

df_A = pd.read_excel("C:\\Users\\saksh\\Dropbox\\SER531\\finalproject\\data1a\\artists.xlsx")
df_B = pd.read_excel("C:\\Users\\saksh\\Dropbox\\SER531\\finalproject\\data1a\\artworks.xlsx")
df_final = pd.merge(df_A, df_B, on='Name')
total_rows=len(df_A.axes[0])
print(total_rows)
print(df_A.columns)
print(df_B.columns)

res_A = df_A.head()
res_B = df_B.head()
res_final = df_final.head()

print(display(res_A))
print(display(res_B))
print(display(res_final))