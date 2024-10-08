from bs4 import BeautifulSoup
import pandas as pd
import requests
import time

all_data = []

html = requests.get("")
soup = BeautifulSoup(html, "lxml")
table = soup.find_all('table', class_ = 'stats_table')[0]

links.table.find_all('a')
links = [l.get("href") for l in links]
links = [l for l in links if"/squads" in l]

team_urls = [f"{l}" for l in links]

for team_url in team_urls:
    team_name = team_url.split("/")][-1].replace("-Stats","")
    data = requests.get(team_url).text
    soup = BeautifulSoup(data,"lxml")
    stats = soup.find_all('table', class_ = 'stats_table')[0]

    if stats and stats.columns:
        stats.columns = stats.columns.droplevel()

    team_data = pd.read_html(str(stats))[0]
    team_data["Teams"] = team_name
    all_teams.append(team_data)
    time.sleep(5)

stat_df = pd.concat(all_teams)
stat_df.to_csv("stats.csv")
