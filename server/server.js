const server = require('http').createServer()

const io = require('socket.io')(server, {
    path: '/',
    serveClient: false,
    pingInterval: 10000,
    pingTimeout: 5000,
    cookie: false
})

server.listen(9000, 'localhost')

io.on('connection', (socket) => {
    console.log(`${socket.id} has connected`)

    socket.on('sPinch', (user) => {
        // socket.broadcast.emit('rPinch', user)
        io.emit('rPinch', user)
    })
    socket.on('sBored', (user) => {
        // socket.broadcast.emit('rBored', user)
        io.emit('rBored', user)
    })
})