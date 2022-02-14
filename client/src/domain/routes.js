var host = `http://localhost:${process.env.VUE_APP_SERVER_PORT}`;
export default {
  self: `http://localhost:${process.env.VUE_APP_PORT}`,
  host: host,
  hostApi: host + "/api",
};
