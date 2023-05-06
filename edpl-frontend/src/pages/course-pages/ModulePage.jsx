import { Button, Layout, Menu } from 'antd';
import { React, useState } from 'react';

const { Content } = Layout;

const modules = [
  {
    id: 1,
    text: 'Введение в React',
    lectures: [
      'Основы React',
      'Создание компонентов',
      'Пропсы и состояния',
    ],
    test: 'Тест по Введению в React',
  },
  {
    id: 2,
    text: 'React Hooks',
    lectures: ['useState', 'useEffect', 'useContext'],
    test: 'Тест по React Hooks',
  },
  {
    id: 3,
    text: 'Роутинг в React',
    lectures: ['React Router', 'Навигация и параметры', 'Приватные маршруты'],
    test: 'Тест по Роутингу в React',
  },
  {
    id: 4,
    text: 'Работа с формами и валидация',
    lectures: ['Контролируемые компоненты', 'Неконтролируемые компоненты', 'Валидация форм'],
    test: 'Тест по Работе с формами и валидации',
  },
  {
    id: 5,
    text: 'Продвинутые темы',
    lectures: ['Контекст и порталы', 'Высокопроизводительный React', 'Тестирование компонентов'],
    test: 'Тест по Продвинутым темам',
  },
];

const ModulePage = () => {
  const [selectedModule, setSelectedModule] = useState(modules[0]);

  return (
    <Layout>
      <Content style={{ padding: '50px' }}>
        <div style={{ display: 'flex', flexWrap: 'wrap' }}>
          <Menu
            mode="inline"
            defaultSelectedKeys={[selectedModule.id.toString()]}
            style={{ borderRadius: '10px', overflow: 'hidden', width: '200px', marginRight: '50px' }}
          >
            {modules.map(module => (
              <Menu.Item key={module.id} onClick={() => setSelectedModule(module)}>
                {module.text}
              </Menu.Item>
            ))}
          </Menu>
          <div>
            <h2>{selectedModule.text}</h2>
            <ul>
              {selectedModule.lectures.map((lecture, index) => (
                <li key={index}>
                  <Button type="link" style={{ borderRadius: '5px' }}>{lecture}</Button>
                </li>
              ))}
            </ul>
            <Button type="primary">{selectedModule.test}</Button>
          </div>
        </div>
      </Content>
    </Layout>
  );
};

export default ModulePage;
