import client, { Channel, Connection, ConsumeMessage } from "amqplib";

export class RabbitMQService {
    async connection() {
        const connection = await client.connect(
            "amqps://xmhiemjp:i_JlXLBa-Uq1U6MSLUw6nTSsbYryajpR@chimpanzee.rmq.cloudamqp.com/xmhiemjp"
        );
        return connection;
    }

    async publishCadastro(payload: any): Promise<boolean> {
        const dataBuffer = Buffer.from(JSON.stringify(payload));
        const connection = await this.connection();
        const channel: Channel = await connection.createChannel();
        await channel.assertQueue("contabancariacadastrar");

        return channel.sendToQueue("contabancariacadastrar", dataBuffer);
    }

    async publishDeposito(payload: any): Promise<boolean> {
        const dataBuffer = Buffer.from(JSON.stringify(payload));
        const connection = await this.connection();
        const channel: Channel = await connection.createChannel();
        await channel.assertQueue("contabancariadepositar");

        return channel.sendToQueue("contabancariadepositar", dataBuffer);
    }

    async publishSaque(payload: any): Promise<boolean> {
        const dataBuffer = Buffer.from(JSON.stringify(payload));
        const connection = await this.connection();
        const channel: Channel = await connection.createChannel();
        await channel.assertQueue("contabancariasacar");

        return channel.sendToQueue("contabancariasacar", dataBuffer);
    }

}
