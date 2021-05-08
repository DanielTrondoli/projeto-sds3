import axios from 'axios';
import Chart from 'react-apexcharts';
import { SaleSum } from 'types/sale';
import { BASE_URL } from 'Utils/requests';

type chartData = {
  series: number[],
  labels: string[]
}

const DonutChart = () => {

  let chartdata: chartData = { labels: [], series: [] }

  console.log(`${BASE_URL}/sum-by-seller`);
  
  axios.get(`${BASE_URL}/sum-by-seller`)
    .then((response) => {

      const data = response.data as SaleSum[];

      const myLabels = data.map( x => x.sellerName);
      const mySeries = data.map( x => x.sum);

      chartdata = { labels: myLabels, series: mySeries}

      console.log(chartdata)
    });

  // const mockData: chartData = {
  //   series: [477138, 499928, 444867, 220426, 473088],
  //   labels: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
  // }

  const options = {
    legend: {
      show: true
    }
  }

  return (
    <Chart
      options={{ ...options, labels: chartdata.labels }}
      series={chartdata.series}
      type="donut"
      height="240"
    />
  );
}

export default DonutChart;